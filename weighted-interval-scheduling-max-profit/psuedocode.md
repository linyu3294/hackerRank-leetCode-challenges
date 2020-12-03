DP Approach
    1) Consider the last subproblem {1,2, ... j} where j is a unit of time
        Assumption: Jobs are sorted by start time
            case 1 : final interval is part of the Opt
            Opt(j) = Opt(j.previous_non_overlap) + p(j) 
            case 2 : final interval is NOT part of the Opt
            Opt(j) = Opt(j-1)
    2)  Recurrence 
        max { Opt(j.previous_non_overlap) + p(j), Opt(j-1))
        Opt[0] = 0; Opt[1] = p(1)
    3) PsuedoCode
        Using Bottom Up approach
            
            swap (x, y, z[]):
                temp = z[x]
                z[x] = z[y]
                z[y] = temp
            
            
            FindPrvOpt (s[], t[]) :
                prevLookUp[]
                for (i = 0 ... s[])
                localMax =0;
                    for (j = 0 ... t[]) 
                        if locaMax < t[j] < s[i] 
                            prevLookUp[i] = j
                return prevLookUp[]    
           
           
            FindOpt(s[], t[], p[]) :
            DP[1] = p[1]
                for (i = 2 ... n)
                    if p[i-1] > p[i] + DP[ prevLookUp[i] ]
                        DP[i] = p[i-1]
                    else :
                        DP[i] = p[i] + DP[ prevLookUp[i] ]
             return DP[]
                    
            
            FindSchedule(dp[]):
                
            return schedule[]
        
        
        
    
    
    