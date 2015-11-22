import json
import calendar
import time

def generateBouncingWave(numRows, secsFromNow):
    dic = {}
    dic["time"] = calendar.timegm(time.gmtime()) + secsFromNow
    tempDic = {}
    totalTime = numRows / 2
    for row in range(numRows):
        tempDic["r" + str(row)] = [[0,0,0], row, 1]
    dic["data"] = tempDic
    return dic

print(generateBouncingWave(5, 0))
