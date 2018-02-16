Attempts to solve the square-sum puzzle. (see https://www.youtube.com/watch?v=G1m7goLCJDY )

## Hamiltonian Path Problem 

Given a number n, arrange the numbers 1 to n into a (hamiltonian) path such that 
the sum of any two adjacent numbers is a square number.

#### Sample: n=15

9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8

## Hamiltonian Cycle Problem

Given a number n, arrange the numbers 1 to n into a (hamiltonian) cycle such that 
the sum of any two adjacent numbers is a square number.

*Note:* Obviously, each such solution yields a Hamiltonian Path Solution as well.

#### Sample: n=32

1, 15, 10, 26, 23, 2, 14, 22, 27, 9, 16, 20, 29, 7, 18, 31, 5, 11, 25, 24, 12, 13, 3, 6, 30, 19, 17, 32, 4, 21, 28, 8

## Program

Finds hamiltonian cycles for n with 32 <= n <= 10000. 
The algorithm recurses and is as such limited by java's stack size limit.

### Usage

Start via `./gradlew run`
