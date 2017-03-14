word = "cbbd"

n = len(word)
T = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    T[i][i] = 1

for l in range(2, n + 1):
    for i in range(n - l + 1):
        j = i + l - 1
        if l == 2 and word[i] == word[j]:
            T[i][j] = 2
        elif word[i]==word[j]:
            T[i][j] = T[i + 1][j - 1] + 2
        else:
            T[i][j] = max(T[i + 1][j], T[i][j - 1])

for i in range(n):
    for j in range(n):
        print(T[i][j], end=" ")
    print("\n")

i, j = 0, n-1

ans = ""
print(i, j)

palindromeLen = T[0][n-1]
ansIndex=0

while palindromeLen > 0:
    if palindromeLen == 1:
        ans += word[j]
        palindromeLen -= 1

    elif T[i][j] == T[i+1][j-1] + 2:
        ans += word[j]
        i += 1
        j -= 1
        palindromeLen -= 2
        ansIndex += 1

    elif T[i+1][j] >= T[i][j-1]:
        i += 1

    else:
        j -= 1

while ansIndex > 0:
    ans += ans[ansIndex-1]
    ansIndex -= 1

print(ans)
