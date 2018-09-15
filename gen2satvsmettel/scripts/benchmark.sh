#!/bin/bash

function init() {
  echo init

  #for mettel
  time_limit=10000

  #replacing time limit reached
  upper_bound=11000

  this_script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

  results_file_path="$2"
  tmp_file_path=$this_script_dir/../tmp.tmp
  softwares_dir=$this_script_dir/../softwares
  gen2sat_software_dir=$softwares_dir/gen2sat
  mettel_software_dir=$softwares_dir/mettel

  problems_dir=$1
  mettel_problems_dir_F=$problems_dir/mettel/F
  mettel_problems_dir_U=$problems_dir/mettel/U
  gen2sat_problems_file_detailed=$problems_dir/gen2sat/detailed/input.txt
  gen2sat_problems_file_undetailed=$problems_dir/gen2sat/undetailed/input.txt

  env_dir=$this_script_dir/../run_env
  log_file=$env_dir/log.txt
  gen2sat_env_dir_detailed=$env_dir/gen2sat_detailed
  gen2sat_env_dir_undetailed=$env_dir/gen2sat_undetailed
  mettel_3val_F_env_dir=$env_dir/mettel_3val_F
  mettel_3val_U_env_dir=$env_dir/mettel_3val_U
  mettel_lukavrona_F_env_dir=$env_dir/mettel_lukavrona_F
  mettel_lukavronb_F_env_dir=$env_dir/mettel_lukavronb_F

}

function create_env() {
  date
  echo creating running env

  rm -rf $env_dir
  mkdir $env_dir
  mkdir $gen2sat_env_dir_detailed
  mkdir $gen2sat_env_dir_undetailed
  mkdir $mettel_3val_F_env_dir
  mkdir $mettel_3val_U_env_dir
  mkdir $mettel_lukavrona_F_env_dir
  mkdir $mettel_lukavronb_F_env_dir
}

function fetch_files() {
  date
  echo fetching problems and programs
  cp $mettel_problems_dir_F/* $mettel_3val_F_env_dir
  cp $mettel_problems_dir_F/* $mettel_lukavrona_F_env_dir
  cp $mettel_problems_dir_F/* $mettel_lukavronb_F_env_dir
  cp $mettel_problems_dir_U/* $mettel_3val_U_env_dir
  cp $gen2sat_problems_file_detailed $gen2sat_env_dir_detailed
  cp $gen2sat_problems_file_undetailed $gen2sat_env_dir_undetailed

  cp $mettel_software_dir/*.jar $mettel_3val_U_env_dir
  cp $mettel_software_dir/*.jar $mettel_3val_F_env_dir
  cp $mettel_software_dir/*.jar $mettel_lukavrona_F_env_dir
  cp $mettel_software_dir/*.jar $mettel_lukavronb_F_env_dir
  cp $gen2sat_software_dir/*.jar $gen2sat_env_dir_detailed
  cp $gen2sat_software_dir/*.jar $gen2sat_env_dir_undetailed
}

function destroy_env() {
  date
  echo destroying running env
  rm -rf $env_dir
}

function run() {
  date
  echo benchmarking 3valF
  cd $mettel_3val_F_env_dir
  java -cp Lukasiewicz.jar:mettel2-util.jar:opencsv.jar Lukasiewicz.tableau.Lukasiewicz.LukasiewiczBenchmark -d . -t $time_limit >> $log_file 2>&1

  date
  echo benchmarking 3valU
  cd $mettel_3val_U_env_dir
  java -cp Lukasiewicz.jar:mettel2-util.jar:opencsv.jar Lukasiewicz.tableau.Lukasiewicz.LukasiewiczBenchmark -d . -t $time_limit >> $log_file 2>&1

  date
  echo benchmarking lukavronaF
  cd $mettel_lukavrona_F_env_dir
  java -cp Lukavrona.jar:mettel2-util.jar:opencsv.jar Lukavrona.tableau.Lukavrona.LukavronaBenchmark -d . -t $time_limit >> $log_file 2>&1

  date
  echo benchmarking lukavronbF
  cd $mettel_lukavronb_F_env_dir
  java -cp Lukavronb.jar:mettel2-util.jar:opencsv.jar Lukavronb.tableau.Lukavronb.LukavronbBenchmark -d . -t $time_limit >> $log_file 2>&1



  date
  echo benchmarking gen2sat_detailed
  cd $gen2sat_env_dir_detailed
  java -jar gen2sat.jar input.txt | grep -iv countermodel | grep -iv proof > result.txt

  date
  echo benchmarking gen2sat_undetailed
  cd $gen2sat_env_dir_undetailed
  java -jar gen2sat.jar input.txt > result.txt

  cd $this_script_dir

  date
  echo done benchmarking
}

function parse() {
  date
  echo parsing results
  rm -f $results_file_path
  echo $results_file_path

  cat $mettel_3val_U_env_dir/Lukasiewicz.csv | cut -d, -f1,2,4 | tail -n+2 | sed 's/\.mtl//' | sed 's/^/"mettel-3val-U",/' | sed 's|\.\/||' | sed 's/\.[0-9][0-9]*//' | sed 's/"//g' | sed 's/true/1/' | sed 's/false/0/'  | sed "s|N/A|$upper_bound|g"  >> "${results_file_path}"
  cat $mettel_3val_F_env_dir/Lukasiewicz.csv | cut -d, -f1,2,4 | tail -n+2 | sed 's/\.mtl//' | sed 's/^/"mettel-3val-F",/' | sed 's|\.\/||' |sed 's/\.[0-9][0-9]*//' | sed 's/"//g' | sed 's/true/1/' | sed 's/false/0/'  | sed "s|N/A|$upper_bound|g"  >> $results_file_path
  cat $mettel_lukavrona_F_env_dir/Lukavrona.csv | cut -d, -f1,2,4 | tail -n+2 | sed 's/\.mtl//' | sed 's/^/"mettel-lukavrona-F",/' | sed 's|\.\/||' | sed 's/\.[0-9][0-9]*//' | sed 's/"//g' | sed 's/true/1/' | sed 's/false/0/'  | sed "s|N/A|$upper_bound|g" >> $results_file_path
  cat $mettel_lukavronb_F_env_dir/Lukavronb.csv | cut -d, -f1,2,4 | tail -n+2 | sed 's/\.mtl//' | sed 's/^/"mettel-lukavronb-F",/' | sed 's|\.\/||' | sed 's/\.[0-9][0-9]*//' | sed 's/"//g' | sed 's/true/1/' | sed 's/false/0/'  | sed "s|N/A|$upper_bound|g" >> $results_file_path
  cat $gen2sat_env_dir_undetailed/result.txt | grep -v ^$| cut -d';' -f1,3,2 |tail -n+2 | sed 's/^/"gen2sat-undetailed;/' | sed 's/;/","/g' | sed 's/$/"/' | sed 's/"//g' | sed 's/unprovable/0/' | sed 's/provable/1/'  >> $results_file_path
  cat $gen2sat_env_dir_detailed/result.txt | grep -v ^$ |cut -d';' -f1,3,2 |tail -n+2 | sed 's/^/"gen2sat-detailed;/' | sed 's/;/","/g' | sed 's/$/"/' | sed 's/"//g' | sed 's/unprovable/0/' | sed 's/provable/1/'  >> $results_file_path
  #use when randoming from mettel
  cat $results_file_path |     sed 's/depth//' | sed 's|\.mtl||' | tr '-' '#' |  sed 's/,\([0-9]\)#/,0\1#/' | sed 's/#\([0-9]\),/#0\1,/' > $tmp_file_path
  mv $tmp_file_path $results_file_path

  #use for Rothenberg
  cat $results_file_path | tr '_' ',' > $tmp_file_path

  mv $tmp_file_path $results_file_path
  date
  echo results are in $results_file_path
}

function generate_problems() {
  date
  echo generating problems
  ./generate_rothenberg.sh $1 $2 $3 >> $log_file 2>&1
  ./generate_problems.sh $this_script_dir $1 $2 $3 Lukavron Lukasiewicz >> $log_file 2>&1
  date
  echo finished generating problems
}

if [ "$#" -eq 0 ]; then
    echo "check inside for the right way to run me."
    exit 0
fi



#1 dir to benchmark
#2 result file path

init $1 $2
create_env
fetch_files
run
parse
if [ "$2" != "nc" ]; then
  destroy_env
fi
