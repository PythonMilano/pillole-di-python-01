#!/usr/bin/env python3

""" Estimator 1.0
    The estimator helps you find those hard estimations they ask you.
    Just call the script, it will ask you a brief feature descrition,
    then it will show you the estimation.
    Press CTRL-C when you're done.
"""

import sys
from random import randrange


fib_n = [1, 1, 2, 3, 5, 8, 13, 21, 54, 75]


def get_estimate(feature):
    " Gets a string input and with a comlpext AI calculates the get_estimation "

    feature_hash = hash(feature)
    feature_hash = int(feature_hash / 10 + 2)
    return fib_n[reduce(feature_hash)]


def reduce(number):
    """ Reduces a number with multiple digits to a single digit
        i.e. 135 -> 1 + 3 + 5 = 9
    """

    #if number < 0:
    #    number *= -1

    while number > 9:
        number = sum([int(char) for char in str(number)])
    
    return number


def test_reduce():
    assert reduce(2) == 2
    assert reduce(1) == 1
    assert reduce(10) == 1
    assert reduce(1000000) == 1
    assert reduce(123456) == reduce(21) == reduce(3) == 3
    assert reduce(-9) == reduce(9) == 9
    assert reduce(-123) == reduce(123) == 6


if __name__ == "__main__":
    while True:
        feature = input("Write the description of a feature: ")
        print(get_estimate(feature))

