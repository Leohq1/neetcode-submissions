class Twitter {
    Map<Integer, Set<Integer>> followList; //userId -> set of followeeIds
    Map<Integer, List<int[]>> tweetList; //userId -> list of [postIds, time]
    int time;

    public Twitter() {
        followList = new HashMap<>();
        tweetList = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        createUser(userId);
        tweetList.get(userId).add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        createUser(userId);
        Set<Integer> followees = followList.get(userId);
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int id : followees){
            map.put(id, tweetList.get(id).size() - 1);
        }
        while(result.size() < 10){
            int recent = -1;
            int follower = -1;
            for(int id : followees){
                int index = map.get(id);
                if(index < 0) continue;
                int t = tweetList.get(id).get(index)[1];
                if(t > recent){
                    recent = t;
                    follower = id;
                }
            }
            if (follower == -1) break;
            int index = map.get(follower);
            result.add(tweetList.get(follower).get(index)[0]);
            map.put(follower, index - 1);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        createUser(followerId);
        createUser(followeeId);
        followList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        createUser(followerId);
        createUser(followeeId);
        followList.get(followerId).remove(followeeId);
    }

    private void createUser(int id){
        if(tweetList.containsKey(id)) return;
        followList.put(id, new HashSet<>());
        followList.get(id).add(id);
        tweetList.put(id, new ArrayList<>());
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */