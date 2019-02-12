# Game Of Life
This is a (rather bad) simulator of Conways Game of Life, but now with **Rules!**
Here's how it works:
* 'GoL life = new GoL(10, 10);' : this just initializes a 10 by 10 array
* 'life.set(1, 2, (char) 49);' : these lines set certain areas of the array to 1 (aka 49 which is 1 in char)
* 'life.Generation();' : this does a generation based on current rules
