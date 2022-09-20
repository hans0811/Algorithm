# Replace switch with dict
# 

day = 2

switcher = {
    0 : 'Sunday',
    1 : 'Monday',
    2 : 'Tuesday'
}


day_name = switcher[day]

print(day_name)

# default
default_day = 8
day_name_default = switcher.get(default_day, 'Unkown')
print(day_name_default)

# With function

def get_sunday():
    return 'Sun.'

def get_monday():
    return 'Mon.'

def get_Tuesday():
    return 'Tue.'

def get_defalut():
    return 'Unknow'

switcher = {
    0 : get_sunday,
    1 : get_monday,
    2 : get_Tuesday
}

day_name_function = switcher.get(default_day , get_defalut)()
print(day_name_function)