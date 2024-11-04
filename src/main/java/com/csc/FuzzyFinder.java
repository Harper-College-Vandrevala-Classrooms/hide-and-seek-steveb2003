package com.csc;

import java.util.ArrayList;


public class FuzzyFinder {
  // Your code goes here!

  public static void main(String args[]) {
    System.out.println("In addition to your search functions, you can write a main function if you wish!");
    FuzzyListGenerator fuzzyListGenerator = new FuzzyListGenerator();
    ArrayList<Fuzzy> fuzzies_random=fuzzyListGenerator.randomizedRainbowFuzzies();
    int linear_search_index = linear_search(fuzzies_random);

    ArrayList<Fuzzy> fuzzies_sorted = fuzzyListGenerator.sortedRainbowFuzzies();
    int binary_search_index = binary_search(fuzzies_sorted);

    int linear_index_sorted = linear_search_index_sorted(fuzzies_sorted);

    int binary_index_random = binary_search_index_random(fuzzies_random);
    
    System.out.printf("The index of the golden fuzzy in a randomized list using linear search: %d\n",linear_search_index);
    System.out.printf("The index of the golden fuzzy in a sorted list using binary search: %d\n",binary_search_index);
    
    System.out.printf("The index of the golden fuzzy in a sorted list using linear search: %d\n",linear_index_sorted);
    System.out.printf("The index of the golden fuzzy in a random list using binary search: %d",binary_index_random);

    int worst_case_iterations = linear_worst_case(fuzzies_random);

    System.out.printf("\nThe worst case scenario running time for linear seach occurs when the golden fuzzy is at the very end of the list. In this case, it would be the %dth index of the list. This means it would take %d iterations for the program to run. However, it depends solely on the length of the fuzzies list.",worst_case_iterations, worst_case_iterations);

    int worst_case_binary_iterations = binary_worst_case(fuzzies_random);
    System.out.printf("\nThe worst case scenario running time for binary seach occurs when keeps halving the size of the interval until the golden fuzzy is the only element left. In this case it takes %d iterations. Even when the list is unsorted, binary is much quicker than the linear method because it follows a logrithmic rate.", worst_case_binary_iterations);
  }

    
  public static int linear_worst_case(ArrayList<Fuzzy> fuzzies_random)
  {
    int worst_case_iterations= fuzzies_random.size();
    return worst_case_iterations;
  }

  public static int binary_worst_case(ArrayList<Fuzzy> fuzzies_random)
  {
    double log_result = Math.log(fuzzies_random.size())/Math.log(2);
    int worst_case_binary_iterations = (int) log_result +1;

    return worst_case_binary_iterations;
  }

  public static int linear_search(ArrayList<Fuzzy> fuzzies_random)
  {
    int index =0;
    int linear_search_index=0;
    while(index<fuzzies_random.size())
    {
      if ((fuzzies_random.get(index).color).equals("gold"))
      {
        linear_search_index = index;
        return linear_search_index;
      }
      else
      {
        index++;
      }
      
    }
    return -1;
  }

  public static int linear_search_index_sorted(ArrayList<Fuzzy> fuzzies_sorted)
  {
    int index =0;
    int linear_index_sorted=0;
    while(index<fuzzies_sorted.size())
    {
      if ((fuzzies_sorted.get(index).color).equals("gold"))
      {
        linear_index_sorted = index;
        return linear_index_sorted;
      }
      else
      {
        index++;
      }
      
    }
    return -1;
  }

  public static int binary_search(ArrayList<Fuzzy> fuzzies_sorted)
  {
    int right_limit=fuzzies_sorted.size()-1;
    int left_limit = 0;
    int binary_search_index =0;
    
    String target = "gold";
    while(left_limit <= right_limit)
    {
      int midpoint = (right_limit+left_limit)/2;
      if (((fuzzies_sorted.get(midpoint)).color).compareTo(target)<0)
      {
        left_limit = midpoint+1;
      }

      else if (((fuzzies_sorted.get(midpoint)).color).compareTo(target)>0)
      {
        right_limit = midpoint-1;
      }

      else if ((fuzzies_sorted.get(midpoint).color).equals(target))
      {
        binary_search_index= midpoint;
        return binary_search_index;
      }
    }
    return -1;

  }

  public static int binary_search_index_random(ArrayList<Fuzzy> fuzzies_random)
  {
    int right_limit=fuzzies_random.size()-1;
    int left_limit = 0;
    int binary_index_random =0;
    
    String target = "gold";
    while(left_limit <= right_limit)
    {
      int midpoint = (right_limit+left_limit)/2;
      if (((fuzzies_random.get(midpoint)).color).compareTo(target)<0)
      {
        left_limit = midpoint+1;
      }

      else if (((fuzzies_random.get(midpoint)).color).compareTo(target)>0)
      {
        right_limit = midpoint-1;
      }

      else if ((fuzzies_random.get(midpoint).color).equals(target))
      {
        binary_index_random= midpoint;
        return binary_index_random;
      }
    }
    return -1;

  }
  
}

