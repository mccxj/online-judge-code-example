def reverse_number(n):
    s = 0
    while n != 0:
        s = s * 10 + n % 10
        n /= 10
    return s


def range_fibonacci(max=100000000):
    a, b = 1, 2
    while a <= max:
        yield a
        a, b = b, a + b


def range_prime(max=100000000):
    if max >= 2:
        yield 2
        prime = [2]

        def is_prime(x):
            for p in prime:
                if x % p == 0:
                    return False
                if p * p > x:
                    return True
            return True

        for i in range(3, max + 1, 2):
            if is_prime(i):
                prime.append(i)
                yield i


def is_prime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, n, 2):
        if n % i == 0:
            return False
        if i * i > n:
            return True
    return True