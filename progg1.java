def find_majority(k):
    def hash_it(q):
        return q

    map_of = [0]*len(k)

    for i in k:
        mapped_to = hash_it(i) #hash function
        map_of[mapped_to]+=1


find_majority([1,2,3,4,3,3,2,4,5,6,1,2,3,4,5,1,2,3,4,6,5])
