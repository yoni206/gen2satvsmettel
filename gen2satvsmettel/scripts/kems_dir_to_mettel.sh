#!/bin/bash

function clearLastLine() {
        sleep 0.01
        tput cuu 1 && tput el
}

function append_problem_from_to() {
  from_file=`realpath $1`
  to_file=`realpath $2`
  tmp_file=tmp.tmp
  cat "$from_file" | awk '!x{x=sub("^F","=>")}1' | sed -f replacements.sed | sed "s/,=/=/g" | sed "s/,$//g"> $tmp_file
  if grep -q "=>" $tmp_file;
  then
    :
  else
    echo $(cat $tmp_file)"=>" > $tmp_file
  fi
  translated_problem=`cat $tmp_file`
  original_file_name=`basename $from_file`
  line=inputSequent-$original_file_name:$translated_problem
  echo $line >> $to_file
  rm $tmp_file
}

function main() {
  main_dir=`realpath $1`
  n=$2
  softwares_dir=$main_dir/softwares
  gen2sat_problems_dir=$main_dir/problems/gen2sat
  rm -rf $gen2sat_problems_dir
  mkdir $gen2sat_problems_dir
  cp $softwares_dir/gen2sat/calculi/* $gen2sat_problems_dir

  kems_problems_dir="$main_dir/problems/KEMS"
  problems_files=`find $kems_problems_dir -path *c1* | grep prove`
  k=0
  for g in $problems_files; do
    for f in `ls $gen2sat_problems_dir`; do
      append_problem_from_to $g $gen2sat_problems_dir/$f
    done
    let "k += 1"
    if [ "$n" != "" ] && [ "$k" -ge "$n" ]; then
        echo exiting - finished!
        exit 0
    fi
  done
  echo $k
}

main $1 $2
