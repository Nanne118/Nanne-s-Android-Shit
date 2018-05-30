
# coding: utf-8

# In[9]:


strg = 'Nanne118!@#$%^&*()_'
i = int.from_bytes(strg.encode('utf-8'), byteorder='big')
print('INT= ', i)
print( )
print('------------------')
print( )
s = int.to_bytes(i, length=len(strg), byteorder='big').decode('utf-8')
print('STR=', s)

