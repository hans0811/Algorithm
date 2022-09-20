
class Test():
    def __bool__(self):
        return False
    
    def __len__(self):
        return 0


print(bool(Test()))