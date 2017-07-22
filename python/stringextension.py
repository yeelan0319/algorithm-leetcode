str = "Heeeeelllooo"
start = 0
current = str[start]
res = []

def isExtension(start, end):
  return end - start + 1 > 2

def appendRes(start, end):
  res.append((start, end))

for index, c in enumerate(str):
  if c != current:
    end = index - 1
    if isExtension(start, end):
      appendRes(start, end)
    start = index
    current = str[start]

if isExtension(start, index):
  appendRes(start, index)

print(res)
