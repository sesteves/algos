def match(pattern, text):
  # match pattern to text greedily
 
  if pattern == '':
    return True
 
  elif pattern[0] == '?':
    if ((len(text) > 0 and match(pattern[1:],text[1:])) # greedy!
    or match(pattern[1:],text)):
      return True
 
  elif pattern[0] == '*':
    if ((len(text) > 0 and match(pattern,text[1:])) # greedy!
    or match(pattern[1:],text)):
      return True
 
  else: # a-z
    if len(text) > 0 and pattern[0] == text[0] and match(pattern[1:],text[1:]):
      return True
 
  # fall through
  return len(text) > 0 and match(pattern,text[1:])
 
 
def test(pattern,text,expected):
  if match(pattern,text) == expected:
    result = 'success'
  else:
    result = 'failure'
 
  print 'test %r %r -> %s' % (pattern,text,result)
 
test("abc", "abc", True)
test("c", "abc", True)
test("ab", "abc", True)
test("abcd", "abc", False)
test("a?c", "abc", True)
test("a?c", "ac", True)
test("a?ac", "aaac", True)
test("a*bc", "abcd", True)
test("a*e", "abcd", False)
test("aaa*aaabc*", "aaaaaaaabc", True)
test("", "", True)
test("", "abc", True)
test("??", "", True)
test("??a", "", False)
test("**", "", True)
test("**a", "", False)
test("abc", "abec", False)
