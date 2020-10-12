public class Main2 {


    findMajority (item, list) :
        int i =0;
        While i < list.length:
            if (list[i] != item) && (fakeId3000compare( item, list[i] ) == true)
                count ++
        if count > (list.length / 2 ):
            return true
        else
            return false

    compareFakeID (list) :
        if list.length = 1
            return M[0]
        else if list.length = 2
            if fakeId3000compare(list[0], list[1]) == true
                return list[0]

    leftList = list.sublist ( 0, list.midpoint )
    rightList = list.sublist ( 0, list.midpoint )

    result = compareFakeID(leftList)
    if result != {null} :
        found = findMajority(result, list)
        if found = true:
            return result
        else:
            result = compareFakeID(rightList)
            found = findMajority(result, list)
            if found = true:
                return result
            else:
                return {null}
    return {null}
}
