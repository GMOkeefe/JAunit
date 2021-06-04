# JAunit
A very basic test runner (along with control flow assistance) implemented in Javagony.

## What is Javagony?
It's Java but you can't use any control flow structures (i.e. loops of any kind, if statements, switch cases, ternary statements).

## Why?
I don't know.

## How do I use it?
Y-you... uh, okay. Right now it's not designed to be imported into other people's code, but if you replace the Main.java with whatever you want to run that should work.

You'll want to add every test using `JAunit.addTest(() -> { /* test goes here */});`, and then you simply call `JAunit.runTests();`.
