from __future__ import absolute_import
from __future__ import print_function
import math

'''
name- merge_sort()
does- recursively devides left and right side of list until length is 1.
        then calls merge() to combine the devided list into a single sorted list.
input- an unsorted list.
returns- a sorted list.
'''
def merge_sort(unsorted_list):
	length = len(unsorted_list)
	if (length <= 1):
		return unsorted_list
	else:
		mid = int(math.floor(length / 2))
		left = merge_sort(unsorted_list[0 : mid])
		right = merge_sort(unsorted_list[mid: length])
		print('')
		sorted_list = merge(left, right);
		return sorted_list


'''
name- merge()
does- combines two lists into one sorted list.
input- two lists.
returns- a sorted, aggregate list.
'''
def merge(left, right):
	sorted_list = []
	j = 0 ; k = 0
	print ('left = ', left, ' ', 'right = ', right)
	
	while len(sorted_list) != len(left)+len(right):
		if(j >= len(left)):
			sorted_list.append(right[k])
			k=k+1
			
		elif(k >= len(right)):
			sorted_list.append(left[j])
			j=j+1
			
		elif(left[j] >= right[k]):
			print(right[k])
			sorted_list.append(right[k])
			k=k+1
			
		elif(left[j] < right[k]):
			print(left[j])
			sorted_list.append(left[j])
			j=j+1
			
	return sorted_list
'''
name- main()
does- driver used to test merge_sort()
'''
	
def main():
	unsorted_list = [1,2,9,7,3,8]
	sorted_list = merge_sort(unsorted_list)
	for i in range(len(sorted_list)):
		print(sorted_list)
main()

