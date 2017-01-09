import unittest


class Test0017(unittest.TestCase):
    def test_problem(self):
        one_to_nine = [3, 3, 5, 4, 4, 3, 5, 5, 4]
        ten_to_nineteen = [3, 6, 6, 8, 8, 7, 7, 9, 8, 8]
        twenty_to_ninety = [6, 6, 5, 5, 5, 7, 6, 6]

        words_len = 0
        sum_1_to_9 = sum(one_to_nine)
        sum_10_to_19 = sum(ten_to_nineteen)
        sum_20_to_90 = sum(twenty_to_ninety)
        #1~9,10~19
        sum_1_to_99 = sum_1_to_9 + sum_10_to_19
        #20~99
        sum_1_to_99 += len(twenty_to_ninety) * sum_1_to_9 + (len(one_to_nine) +
                                                             1) * sum_20_to_90

        #1~99
        words_len += sum_1_to_99
        #100~999, 'hundred and' => 10
        words_len += len(one_to_nine) * sum_1_to_99 + 100 * (
            sum_1_to_9 + 10 * len(one_to_nine)) - 3 * len(one_to_nine)
        #1000
        words_len += 11
        self.assertEqual(words_len, 21124)