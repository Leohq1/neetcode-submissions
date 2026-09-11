class TimeMap:

    def __init__(self):
        self.keyStore = {}  # key : list of [val, timestamp]

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.keyStore:
            self.keyStore[key] = []
        self.keyStore[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res, values = "", self.keyStore.get(key, [])

        if not values:
            return res

        l, r = 0, len(values) - 1

        while l < r - 1:
            m = (l + r) // 2

            if values[m][1] <= timestamp:
                l = m
            else:
                r = m

        if values[r][1] <= timestamp:
            return values[r][0]

        if values[l][1] <= timestamp:
            return values[l][0]

        return ""