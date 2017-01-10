import unittest


class Test0022(unittest.TestCase):
    def test_problem(self):
        f = open('p022_names.txt', 'r')
        words = [w[1:-1] for w in f.read().split(',')]
        f.close()
        words.sort()
        score = sum([
            sum([ord(c) - ord('A') + 1 for c in w]) * (i + 1)
            for i, w in enumerate(words)
        ])
        self.assertEqual(score, 871198282)