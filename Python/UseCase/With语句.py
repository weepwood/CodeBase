f = open("./resource/text.txt", "r")
s = f.read()
print(s)
f.close()

# 使用with重构
with open("./resource/text.txt", "r") as f:
    s = f.read()
    print(s)
