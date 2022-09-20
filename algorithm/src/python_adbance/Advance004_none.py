# None is not equal '', [] or False

from unittest.mock import NonCallableMagicMock


a = ''
b = False
c = []

print(a == None)
print(b == None)
print(c == None)

print(a is None)

print(type(None))


#if not a vs. of a is None

def fun():
    return None

#a = fun()
a = []
if not a:
    print('S')
else:
    print('F')

if a is None:
    print('a is None, S')
else:
    print('a is None, F')


# can be used on None, '', [], False
if a:
    pass

if not a:
    pass

if None:
    pass

# None Fasle


class TestAAA():
    pass

class Test1():
    def __len__(self):
        return 0


test = TestAAA()
test1 = Test1()

if test:
    print('S')


if test1:
    print('S')

print(bool(None))
print(bool([]))
print(bool(test))