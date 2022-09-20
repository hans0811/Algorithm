# list 
# Set comprehensions -> can be applied on list, set, tuple and map

a = [1, 2, 3, 4, 5, 6, 7, 8]

# for, map

#b = [i*i for i in a]
b = [i**2 for i in a]

print(b)


# condition, map filter

b = [i**3 for i in a if i >= 5]

print(b)

aset = {1, 2, 3, 4, 5, 6, 7, 8}

bSet = [i**3 for i in aset if i >= 5]

print('List: ' + str(bSet))

bSet = {i**3 for i in aset if i >= 5}

print('Set: ' + str(bSet))


# map comprehensions, (map need iterator, .items())

students = {
    'A': 8,
    'B': 20,
    'C': 15
}

b = [ key for key, value in students.items()]
print(b)

b = {key for key, value in students.items()}
print(b)

b = {value:key for key, value in students.items()}
print(b)

b = (key for key, value in students.items())
print(b) # only print memory address
for x in b:
    print(x)