#002 Add Two Numbers
py_library(
    name = "addtwonumbers",
    srcs = ["addtwonumbers.py"],
    deps = [
        "//python/util:ListNode",
    ],
)
py_test(
    name = "addtwonumbers_test",
    srcs = ["addtwonumbers_test.py"],
    deps = [
        ":addtwonumbers",
        "//python/util:LinkedList",
    ],
)

# 001 Two Sum
py_library(
    name = "twosum",
    srcs = ["twosum.py"],
)
py_test (
  name = "twosum_test",
  srcs = ["twosum_test.py"],
  deps = [
      ":twosum",
  ],
)
