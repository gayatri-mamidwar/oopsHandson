Multi-threaded Sum Calculation

Problem Statement:
Given an array of 1 million random numbers, divide the array into N chunks (N = number of available cores).
Figure out how do you find number of available cores
Implementation :
Use Callable to compute the sum of each chunk, and retrieve the final sum using Future objects.