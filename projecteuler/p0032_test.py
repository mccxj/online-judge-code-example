import unittest


class Test0032(unittest.TestCase):
    def test_problem(self):
        choose = [0] * 9  #mark which num is selected.
        curr = [0] * 9  # selected num.
        products = []

        def check_num(pos):
            # if all num is selected, check.
            if pos == 9:
                product = curr[5] * 1000 + 100 * curr[6] + 10 * curr[7] + curr[
                    8]
                # A * BCDE = FGHI or AB * CDE = FGHI
                if curr[0] * (
                        curr[1] * 1000 + 100 * curr[2] + 10 * curr[3] + curr[4]
                ) == product or (10 * curr[0] + curr[1]) * (
                        100 * curr[2] + 10 * curr[3] + curr[4]) == product:
                    products.append(product)

            for i in range(0, 9):
                if choose[i] == 0:
                    choose[i] = 1
                    curr[pos] = i + 1
                    check_num(pos + 1)
                    choose[i] = 0

        check_num(0)  #check from pos 0
        self.assertEqual(sum(set(products)), 45228)