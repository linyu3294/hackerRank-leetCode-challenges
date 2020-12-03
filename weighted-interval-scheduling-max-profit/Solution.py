def partition(s, p, t, begin, end):
    pivot_idx = begin
    for i in range(begin + 1, end + 1):
        if t[i] <= t[begin]:
            pivot_idx += 1
            t[i], t[pivot_idx] = t[pivot_idx], t[i]
            s[i], s[pivot_idx] = s[pivot_idx], s[i]
            p[i], p[pivot_idx] = p[pivot_idx], p[i]

    t[pivot_idx], t[begin] = t[begin], t[pivot_idx]
    s[pivot_idx], s[begin] = s[begin], s[pivot_idx]
    p[pivot_idx], p[begin] = p[begin], p[pivot_idx]
    return pivot_idx


def quick_sort_recursion(s, p, t, begin, end):
    if begin >= end:
        return
    pivot_idx = partition(s, p, t, begin, end)
    quick_sort_recursion(s, p, t, begin, pivot_idx - 1)
    quick_sort_recursion(s, p, t, pivot_idx + 1, end)


def quick_sort(s, p, t, begin, end):
    if end is None:
        end = len(t) - 1
    return quick_sort_recursion(s, p, t, begin, end)


def find_prev_opt(s, t):


# prev_look_up = [None] * len(s)
# for i in range(len(s)):
#     local_max = 0
#     for j in range(len(t)):
#         if (t[j] > local_max) & (t[j] <= s[i]) & (i != j):
#             prev_look_up[i] = j
#
# return prev_look_up


def find_opt(p, prev_look_up):
    dp = [None] * len(p)
    dp[0] = p[0]
    for i in range(1, len(p)):
        prev_base = 0;
        if prev_look_up[i] is not None:
            prev_base = dp[prev_look_up[i]]
        if dp[i - 1] > p[i] + prev_base:
            dp[i] = dp[i - 1]
        else:
            dp[i] = p[i] + prev_base
    return dp


# def make_schedule(dp, prev_look_up, i, schedule):
#     if i == 0:
#         schedule.append(0)
#         return schedule
#     if dp[i] > dp[i - 1]:
#         schedule.append(i)
#         if prev_look_up[i] is None:
#             return schedule
#         return make_schedule(dp, prev_look_up, prev_look_up[i], schedule)
#     else:
#         return make_schedule(dp, prev_look_up, i - 1, schedule)


# def calc_max_profit(profit, schedule):
# max_profit = 0;
# for i in range(len(schedule)):
#     max_profit = max_profit + profit[schedule[i]]
# return max_profit
def calc_max_profit(dp):
    return dp[len(dp) - 1]


class Solution(object):
    def __init__(self):
        return None

    def jobScheduling(self, start_time, end_time, profit):
        """
        :type startTime: List[int]
        :type endTime: List[int]
        :type profit: List[int]
        :rtype: int
        """
        start = 0
        end = None
        quick_sort(start_time, profit, end_time, start, end)
        prev_look_up = find_prev_opt(start_time, end_time)
        dp = find_opt(profit, prev_look_up)
        result = []
        # opt_schedule = make_schedule(dp, prev_look_up, len(dp) - 1, result)
        print("   start", "  finish", "    prv", "  profit", "  opt", "")
        for i in range(len(s)):
            print(
                i, " ",
                s[i], "     ",
                t[i], "      ",
                prev_look_up[i], "   ",
                p[i], "    ",
                dp[i], "   "
            )

        # print("\n", opt_schedule)
        return calc_max_profit(dp)


if __name__ == '__main__':
    # Test Case 1
    s = [1, 2, 3, 3]
    t = [3, 4, 5, 6]
    p = [50, 10, 40, 70]
    # Output: 120
    # Explanation: The subset chosen is the first and fourth job.
    # Time range[1 - 3] + [3 - 6], we get profit of 120 = 50 + 70.
    # Test Case 2
    # s = [1, 1, 1]
    # t = [2, 3, 4]
    # p = [5, 6, 4]
    # Output: 6
    # Test Case 3
    # s = [1, 2, 3, 4, 6]
    # t = [3, 5, 10, 6, 9]
    # p = [20, 20, 100, 70, 60]
    # Output: 150
    # Explanation: The subset chosen is the first, fourth and fifth job.
    # Profit obtained 150 = 20 + 70 + 60.
    # Test Case 4
    s = [33, 8, 9, 18, 16, 36, 18, 4, 42, 45, 29, 43]
    t = [40, 16, 32, 39, 46, 43, 28, 13, 44, 46, 39, 44]
    p = [2, 6, 5, 14, 5, 19, 5, 12, 19, 14, 14, 17]
    # Output: 67
    test = Solution()
    print(test.jobScheduling(s, t, p))
