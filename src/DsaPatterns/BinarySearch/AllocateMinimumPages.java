package src.DsaPatterns.BinarySearch;
/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 103
 */
public class AllocateMinimumPages {
    public static void main(String[] args) {
        int books[]= {12, 34, 67, 90};
        System.out.println(findPages(books,2));

    }
    public static int findPages(int[] books, int k) {
        int n = books.length;
        if(n<k){
            return -1;
        }
        int totalPages = 0;
        int maxPagesInBook = 0;
        for(int page : books){
            totalPages+=page;
            maxPagesInBook = Math.max(maxPagesInBook,page);
        }
        int low = maxPagesInBook,high = totalPages;
        int res=-1;
        while(low<=high){
            int guessedNoOfPages = low+(high-low)/2;
            if(allocationPossible(books, k, guessedNoOfPages, n)){
                res=guessedNoOfPages;
                high=guessedNoOfPages-1;
            }
            else{
                low=guessedNoOfPages+1;
            }
        }
        return res;

    }
    public static boolean allocationPossible(int[] books, int k, int limit, int n){
        int countOfStudentNeeded=1;
        int pages=0;

        for(int i=0;i<n;i++){
            if(pages+books[i]<=limit){
                pages+=books[i];
            }
            else{
                countOfStudentNeeded++;
                pages = books[i];
                if(countOfStudentNeeded>k){ // if student count > number of students
                    return false;
                }
            }

        }
        return true;
    }
}
