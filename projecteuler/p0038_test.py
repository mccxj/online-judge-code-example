import unittest


class Test0038(unittest.TestCase):
    def test_problem(self):
        # 9*1 or 9x*1 or 9xx*1 or 9xxx*1
        def check(n, m):
            s = ""
            for i in range(1, 9):
                s += str(n * i)
                if len(s) > 9:
                    break
                if len(s) == 9:
                    cs = list(s)
                    cs.sort()
                    if ''.join(cs) == '123456789' and int(s) > m:
                        m = int(s)
            return m

        m = 918273645  # 9*1
        for n in range(91, 99):
            m = check(n, m)
        for n in range(912, 999):
            m = check(n, m)
        for n in range(9123, 9999):
            m = check(n, m)
        self.assertEqual(m, 104743)
