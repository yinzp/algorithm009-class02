学习笔记

(1)深度优先搜索 DFS: depth ﬁrst search
   更加适用于现实中的很多业务场景--->启发式搜索
(2)广度优先搜索 BFS: breadth ﬁrst search
搜索：一般就是把所有的节点全部遍历一次，找到想要的结果。


递归模版：

visited = set()  
def dfs(node, visited):
	if node in visited: # terminator
        # already visited
        return
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children():
		if not next_node in visited:
			dfs(next node, visited
非递归写法：

def DFS(self, tree):
	if tree.root is None:
		return []
    visited, stack = [], [tree.root]
    while stack:
		node = stack.pop()
        visited .add(node)
       	process (node)
        nodes = generate_related_nodes(node)
        stack .push(nodes)
# other processing work
...


def BFS(graph, start, end):
	queue = []
    queue .append([start])
    visited .add(start)
    while queue:
    	node = queue.pop()
        visited .add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue .push(nodes)
# other processing work
...

(3)贪心算法 Greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
贪心：当下做全局最优判断

回溯：能够回退

动态规划：最有判断+回退

心算法 Greedy 贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码 等。

(4)二分查找
二分查找的前提：

目标函数单调性（单调递增或者递减）
存在上下界（bounded）
能够通过索引访问（index accessible）
代码模板：

left, right = 0, len(array) - 1
while left <= right:
	mid = (left + right) / 2
    if array[mid] == target:
    	# find the target!!
        break or return result
    elif array[mid] < target:
    	left = mid + 1
    else:
    	right = mid - 1
