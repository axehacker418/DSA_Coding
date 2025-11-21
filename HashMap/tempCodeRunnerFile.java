if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]+1));
                
            }
            else{
                map.put(nums[i],1);
            }