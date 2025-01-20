package org.example;

import java.util.LinkedList;

public class links {
    private final LinkedList<String []> myUrls = new LinkedList<>();

    public links(){
        myUrls.add(new String[]{"https://www.tcgplayer.com/product/282401/pokemon-swsh11-lost-origin-sword-and-shield-ultrapremium-collection-charizard?country=US&utm_campaign=18147618381&utm_source=google&utm_medium=cpc&utm_content=&utm_term=&adgroupid=&gad_source=1&gclid=Cj0KCQiA4L67BhDUARIsADWrl7HhwFJMKRewtKD8bfK0eb_CZz5sv9DS50mPvYGfmubx1L9O2V8eQowaAmr9EALw_wcB&Language=English"});
        myUrls.add(new String[]{"https://www.tcgplayer.com/product/263873/pokemon-swsh09-brilliant-stars-charizard-v-alternate-full-art?page=1&Language=English&Condition=Near+Mint"});
        myUrls.add(new String[]{"https://www.tcgplayer.com/product/272419/Pokemon-SWSH10%20Astral%20Radiance-Origin%20Forme%20Palkia%20V%20Alternate%20Full%20Art?xid=aba9c015f-9f83-41bc-afc3-2d6c8a276429&Language=English&Condition=Near+Mint&page=1"});
        myUrls.add(new String[]{"https://www.tcgplayer.com/product/272427/Pokemon-SWSH10%20Astral%20Radiance-Origin%20Forme%20Dialga%20V%20Alternate%20Full%20Art?xid=acf2ada3b-839e-4017-961f-9a08a9f3e2ad&Language=English"});
        myUrls.add(new String[]{"https://www.pricecharting.com/game/pokemon-base-set-2/charizard-4#completed-auctions-graded", "9"});
    }

    public LinkedList<String[]> getList(){
        return  myUrls;
    }

    public String[] getIndex(int index){
        return  myUrls.get(index);
    }
}
