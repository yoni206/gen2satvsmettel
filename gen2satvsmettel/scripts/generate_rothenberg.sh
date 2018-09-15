#!/bin/bash

function init() {
  this_script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
  softwares_dir=$this_script_dir/../softwares
  gen2sat_software_dir=$softwares_dir/gen2sat
  problems_dir=$1
  mettel_problems_dir_F=$problems_dir/mettel/F
  mettel_problems_dir_U=$problems_dir/mettel/U
  gen2sat_problems_dir_detailed=$problems_dir/gen2sat/detailed
  gen2sat_problems_dir_undetailed=$problems_dir/gen2sat/undetailed
  tmp_file=tmp.tmp

  rm -f $tmp_file
  rm -rf $problems_dir/*
  mkdir -p $mettel_problems_dir_F
  mkdir -p $mettel_problems_dir_U
  mkdir -p $gen2sat_problems_dir_detailed
  mkdir -p $gen2sat_problems_dir_undetailed

  cp $softwares_dir/gen2sat/calculi/LukavronDetailed.txt $gen2sat_problems_dir_detailed/input.txt
  cp $softwares_dir/gen2sat/calculi/LukavronUndetailed.txt $gen2sat_problems_dir_undetailed/input.txt
}

function generate() {
  max_size=$1
  interval=$2

  java -jar $gen2sat_software_dir/formulagenerator.jar rothenberg $max_size $interval  > $tmp_file
}

function deploy() {
  while read line; do
    name=`echo $line | cut -d_ -f1-3`
    formula=`echo $line | cut -d_ -f4`
    echo "F $formula" > $mettel_problems_dir_F/$name.mtl
    echo "U $formula" > $mettel_problems_dir_U/$name.mtl
    echo "inputSequent-$name: =>$formula" >> $gen2sat_problems_dir_detailed/input.txt
    echo "inputSequent-$name: =>$formula" >> $gen2sat_problems_dir_undetailed/input.txt
  done <$tmp_file
}

function clean() {
  rm $tmp_file
}


if [ "$#" -eq 0 ]; then
    echo "look inside and check what arguments are needed"
fi

#1 - max size
#2 - interval
#3 - problems dir


init $3
generate $1 $2
deploy
clean
