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
        tool_calc,positivity,cls,size,answer,time = line.split(",")
        add(results,tool_calc,positivity,cls,size,answer,time)
    #stats = get_stats(results)
    pp.pprint(results)

def get_stats(results):
    stats = {}
    for cls in results:
        stats[cls] = {}
        for positivity in results[cls]:
            stats[cls][positivity] = {}
            for tool_calc in results[cls][positivity]:
                stats[cls][positivity][tool_calc] = {}
                times = [int(results[cls][positivity][tool_calc][size][1]) for size in results[cls][positivity][tool_calc]]
                per25 = numpy.percentile(times, 25)
                med = numpy.median(times)
                per75 = numpy.percentile(times, 75)
                stats[cls][positivity][tool_calc]["per25"] = per25
                stats[cls][positivity][tool_calc]["per50"] = med
                stats[cls][positivity][tool_calc]["per75"] = per75
    return stats



def add(results,tool_calc,positivity,cls,size,answer,time):
    if cls not in results:
        results[cls] = {}
    if positivity not in results[cls]:
        results[cls][positivity] = {}
    if tool_calc not in results[cls][positivity]:
        results[cls][positivity][tool_calc] = {}
    results[cls][positivity][tool_calc][size] = [answer, time]


if __name__ == "__main__":
    f = sys.argv[1]
    main(f)
