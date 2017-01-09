import unittest


class Test0019(unittest.TestCase):
    def test_problem(self):
        leap_days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        notleap_days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

        is_leap = lambda x: x % 4 == 0 and (x % 400 == 0 or x % 100 != 0)
        # assume monday to sunday as 1,2,3,4,5,6,0(mod 7)
        # then monday is 1, 1900 is not a leap year.
        first, time = (1 + 365) % 7, 0
        for year in range(1901, 2000):
            days = leap_days if is_leap(year) else notleap_days
            for d in days:
                if first == 1:
                    time += 1
                first = (first + d) % 7

        self.assertEqual(time, 171)