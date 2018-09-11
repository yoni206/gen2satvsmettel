#!/bin/bash

#first arg: result path
#second arg: max depth
#third arg: jumps
#forth arg: num of formulas for each depth

function init {
	problems_out_dir=`realpath $1`
	rm -rf $problems_out_dir/*
	calculus_name_gen2sat=$2
	calculus_name_mettel=$3
	this_script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
	#tmp_dir=~/tmp/gen2sat
	tmp_dir=$this_script_dir/tmp
	rm -rf $tmp_dir/*
	mkdir -p $tmp_dir
	mkdir -p $tmp_dir/mtl
	tmp_prop_file=$tmp_dir/gen.properties
	default_prop_file=$this_script_dir/$calculus_name_mettel.properties


	current_dir=`pwd`
	mettel_dir=$this_script_dir/../softwares/mettel
	mkdir -p $problems_out_dir
	calculi_dir=$this_script_dir/../softwares/gen2sat/calculi
	n_for_mettel=10 #mettel crashes if we ask for to much. So we do it in small steps.

	local detailed=Detailed
	local undetailed=Undetailed
	gen2sat_calculus_file_detailed=$calculi_dir/$calculus_name_gen2sat$detailed.txt
	gen2sat_calculus_file_undetailed=$calculi_dir/$calculus_name_gen2sat$undetailed.txt
}

#first arg: max depth
#second arg: intervals
#third arg: number of problems for each depth
function generate_problems {
	local max_depth=$1
	local interval=$2
	local n=$3
	local depth=$interval
	while [ $depth -le $max_depth ]; do
		generate_n_formulas_of_size_m $n $depth
		depth=$[$depth +$interval]
	done
}


#first arg: n
#second arg: m
function generate_n_formulas_of_size_m {
	local n=$1
	local m=$2
	local bign=$[$n_for_mettel * $m]
	put_good_prop_file_in_tmp $m
	generate_n_m_to_tmp $bign
	filter_tmp_files $m
	mv_tmp_to_problems_dir $m
}



#second arg: m

function put_good_prop_file_in_tmp {
	local m=$1
	cp $default_prop_file $tmp_prop_file
	cat $tmp_prop_file | sed 's:^[ \t]*valuation.generate[ \t]*=\([ \t]*.*\)$:valuation.generate = 0:' > $tmp_prop_file.1
	cat $tmp_prop_file.1 | sed "s:^[ \t]*formula.generate[ \t]*=\([ \t]*.*\)$:formula.generate = $n:" > $tmp_prop_file.2
	cat $tmp_prop_file.2 | sed "s:^[ \t]*formula.depth[ \t]*=\([ \t]*.*\)$:formula.depth = $m:" > $tmp_prop_file.3
	cat $tmp_prop_file.3 | sed "s:^[ \t]*formula.variables.number[ \t]*=\([ \t]*.*\)$:formula.variables.number = $m:" > $tmp_prop_file.4
	cat $tmp_prop_file.4 > $tmp_prop_file
	rm -f $tmp_prop_file.1 $tmp_prop_file.2 $tmp_prop_file.3 $tmp_prop_file.4
}

#arg: bigger number n
function generate_n_m_to_tmp {
	local n=$1
	local i=10
	local RandomExpressionGenerator=RandomExpressionGenerator
	cd $mettel_dir
	while [ $i -le $n ]; do
			java -cp $calculus_name_mettel.jar:mettel2-util.jar $calculus_name_mettel.language.$calculus_name_mettel.util.$calculus_name_mettel$RandomExpressionGenerator -d $tmp_dir/mtl -p $tmp_prop_file
			i=$[$i +10]
	done
	cd $current_dir
}

#arg: m
function filter_tmp_files {
	#We keep only files with m depth
	local m=$1
	cd $tmp_dir/mtl
	grep -nir total.symbol.max.depth.=.$m . | cut -d: -f1 > good_mtl_files.tmp
	remove_dot_slash good_mtl_files.tmp
	remove_all_but good_mtl_files.tmp $n $m
	cd $current_dir

}

#arg path to a file with a list of files to keep
function remove_all_but {
	local good_files_list_file=$1
	local n=$2
	local m=$3
	local i=1
	echo n=$n m=$m good size=`cat $good_files_list_file |wc -l`
	for f in `cat $good_files_list_file`; do
		tail -n 1 $f > depth$m-$i.mtl
		i=$[$i +1]
		if [ "$i" -gt "$n" ]; then
			break
		fi
	done
	for f in `ls | grep -v depth`; do
		rm -f $f
	done

}

function mv_tmp_to_problems_dir {
	local m=$1
	mkdir -p $problems_out_dir/formulas
	cp -r $tmp_dir/mtl/* $problems_out_dir/formulas
}

#arg path to file
function remove_dot_slash {
	local file_path=$1
	local tmp_file_path=$file_path.tmp
	cat $file_path | sed "s:./::" > $file_path.tmp
	cat $file_path.tmp > $file_path
	rm -f $file_path.tmp
}

#arg: path of file
function translate_lines_to_pipes {
	local file_path=$1
	piped=""

	for f in `cat $file_path`; do
		piped="$piped\|$f"
	done
	piped="${piped:2:${#piped}-1}"
	echo $piped > $file_path
}

function generate_for_mettel {
	cd $problems_out_dir/formulas
	mkdir -p $problems_out_dir/mettel/F
	mkdir -p $problems_out_dir/mettel/U
	for f in `ls .`; do
		formula=`cat $f`
		echo "F $formula" > $problems_out_dir/mettel/F/$f
		echo "U $formula" > $problems_out_dir/mettel/U/$f
	done

	cd $current_dir
}

function generate_for_gen2sat {
	cd $problems_out_dir/formulas
	mkdir -p $problems_out_dir/gen2sat/detailed
	mkdir -p $problems_out_dir/gen2sat/undetailed
	cat $gen2sat_calculus_file_detailed > $problems_out_dir/gen2sat/detailed/input.txt
	cat $gen2sat_calculus_file_undetailed > $problems_out_dir/gen2sat/undetailed/input.txt
	for f in `ls .`; do
		formula=`cat $f`
		echo "inputSequent-$f: =>$formula" >> $problems_out_dir/gen2sat/detailed/input.txt
		echo "inputSequent-$f: =>$formula" >> $problems_out_dir/gen2sat/undetailed/input.txt
	done
	cd $current_dir
}

#arg1: dest dir
#arg2: max m
#arg3: interval
#arg4: n (number of formulas for each m)
#arg5: calculus name gen2sat
#arg6: calculus name mettel

init $1 $5 $6
generate_problems $2 $3 $4
generate_for_mettel
generate_for_gen2sat
rm -rf $tmp_dir
rm -rf $problems_out_dir/formulas
