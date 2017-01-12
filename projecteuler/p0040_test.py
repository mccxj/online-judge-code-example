import unittest


class Test0040(unittest.TestCase):
    def test_problem(self):
        #0.123456789101112131415161718192021...
        digit = [9, 2 * 90, 3 * 900, 4 * 9000, 5 * 90000, 6 * 900000]

        def find(seq):
            group = 0
            while digit[group] < seq:
                seq -= digit[group]
                group += 1
            # how many digits this group have is (group+1), get current pos.
            m = seq % (group + 1)
            if m == 0:
                # get last digit
                return (10**group + seq / (group + 1) - 1) % 10
            else:
                # get xth digit, equal to last (group-i+1)th digit.
                return (10**group + seq /
                        (group + 1)) / 10**(group + 1 - m) % 10

        product = find(1) * find(10) * find(100) * find(1000) * find(
            10000) * find(100000) * find(1000000)
        self.assertEqual(product, 210)