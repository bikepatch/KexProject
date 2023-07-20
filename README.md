# KexProject
This is a solution for test task of Mocking in Kex project performed by Ivan Fomenko. Here you may find answers to the 1st and 2nd questions of the test case. Solution of the 3rd is located in tests folder.
# 1st question
I can only think of a way of implementing mocking without using it. We may create a descendant class that extends our abstract Foo and sets concrete values that are needed for our case. This way we are not using mocks but somehow we use it because we implement quite simular logic.
# 2nd question
There is one obvious problem that comes of setting concrete values in Foo class. These values are solid, we can use analogy with the laws, we get much less freedom in our behaviour because of that. There might be different outcomes for foo() with other values corresponding to x and y that we cannot reach with stated ones. For better perpectives it would be greater to parametrize x and y in mock tests not to state them before.



