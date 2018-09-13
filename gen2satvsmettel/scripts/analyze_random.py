import sys
import os
import numpy
import pprint

pp = pprint.PrettyPrinter(indent=4)

def main(f):
    results = {}
    with open(f, "r") as a:
        lines = a.readlines()
    for line in lines:
        line = line.strip("\n")
        tool_calc,problem_name,answer,time = line.split(",")
        size, sn = problem_name.split("#")
        add(results, tool_calc, size, sn, answer, time)
    stats = get_stats(results)
    pp.pprint(stats)

def get_stats(results):
    stats = {}
    for key in results:
        stats[key] = {}
        for tool_calc in results[key]:
            stats[key][tool_calc] = {}
            times = [int(results[key][tool_calc][sn][1]) for sn in results[key][tool_calc]]
            per25 = numpy.percentile(times, 25)
            med = numpy.median(times)
            per75 = numpy.percentile(times, 75)
            stats[key][tool_calc]["per25"] = per25
            stats[key][tool_calc]["per50"] = med
            stats[key][tool_calc]["per75"] = per75
    return stats



def add(results, tool_calc, size, sn , answer, time):
    if size not in results:
        results[size] = {}
    if tool_calc not in results[size]:
        results[size][tool_calc] = {}
    results[size][tool_calc][sn] = [answer, time]


if __name__ == "__main__":
    f = sys.argv[1]
    main(f)
