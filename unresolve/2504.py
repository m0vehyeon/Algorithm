st = input()

small = 0
big = 0
start = st[0]

for v in st:
    if v == "(":
        small += 1
    elif v == ")":
        small -= 1
    elif v == "[":
        big += 1
    elif v == "]":
        big -= 1

    if small < 0 or big < 0:
        print(0)
    else:
        if start == "(":

        elif start == "[":

        else:
            print(0)