import copy

class Book:
    pass

class BookCollection:
    
    def __init__(self):
        self.data = ['<book1>', '<book2>', '<book3>']
        self.cur = 0
        pass
    
    def __iter__(self):
        return self

    def __next__(self):
        if self.cur >= len(self.data):
            raise StopIteration()
        r = self.data[self.cur]
        self.cur += 1
        return r
    pass


books = BookCollection()
# copy.deepcopy
books_copy = copy.copy(books)

# Cannot use next on the list tuple
print(next(books))

for book in books:
    print(book)

# only use once
# for book in books:
#     print(book)


for book in books_copy:
    print(book)

# generator
# print 0~100000

n = [ i for i in range(0, 10001)]

n1 = ( i for i in range(0, 10001))

# for i in n:
#     print(i)

def gen(max):
    n = 0
    while n <= max:
       #print(n)
        n+=1
        yield n


print(gen(10000))

g = gen(1000)
print(next(g))
print(next(g))
print('test')

for i in g:
    print(i)