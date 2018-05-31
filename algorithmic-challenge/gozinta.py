f=lambda x:[y+[x] for k in range(1,x) if x%k<1 for y in f(k)]or[[x]]
print f(12)
