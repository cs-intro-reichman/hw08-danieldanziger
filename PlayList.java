/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        //// replace the following statement with your code
        if (this.size == this.tracks.length) {                   //if the list is full returns false
            return false;
        }
        this.tracks[this.size-1] = track;                          //otherwise, add the track to the size (one more; the track is size-1 thats why just size) and add one to the total size
        this.size++;
        return true;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        //// replace the following statement with your code
        
        return "";
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        //// replace this comment with your code
        if (size != 0) {
            this.tracks[size-1] = null;            //as long as the tracks size is not 0, go to the end of the size, make the last one (size -1) null, than "erase" is (--)
            this.size --;
        }
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        //// replace the following statement with your code
      int totalDur =0;
      for (int i = 0; i < this.size; i++) {
        totalDur += this.tracks[i].getDuration();     //get each track's duration and add to totalDur
     
    }
        return totalDur;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        //// replace the following statement with your code
        for (int i = 0; i < size; i++) {
            if (this.tracks[i].getTitle().toLowerCase().equals(title.toLowerCase())) {    //if the track in index i's title in lowcap is equal to the given one in lowcap return the index of it
             return i;
             }
         }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        //// replace the following statement with your code
        if(i < 0 || i > this.size || this.size == this.maxSize){                   //as long as the index is not negative, larger than the size or the list is full return false
            return false;
        }
           for (int j = this.size-2; j > i; j++) {                  //make j the last index of the size, than for all indexes larger than i move them one forward
            this.tracks[j+1] = tracks[j];
           }  
           tracks[i] = track;                                      //now make the track in index i the new track we want to add and add to the total size
           size++;
           return true;                                  
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
        //// replace this comment with your code
        if (this.size != 0 && i > 0 && i < this.size) {
            if (i== this.size -1){                          //if the track we want to remove is the last one, just make it null
             this.tracks[i] = null;
            }
            else {
                for (int j = i; j < this.size -1; j++) {   
                    this.tracks[j] = this.tracks[j+1];       //point that the track in j will now be the track in j+1 (the track in j-1 will point to j+1 meaning j will be 'removed')
                }
            }
            this.size--;
        }
    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        //// replace this comment with your code
        if (indexOf(title) != -1) {                     //if the index that has the given title from the list is not -1 = it is in there, remove it
            remove (indexOf(title));
        }
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        //// replace this comment with your code
        if (this.getSize() > 0);
        remove (0);
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        //// replace this comment with your code
        if (this.size + other.size <= this.maxSize) {                 //if both sizes together are lower or equal to the max size
            int newTotSize = this.size + other.size;                  // make the new max size the sum of both tracks
                int j = 0;                                            //j for the other track
                for (int i = this.size; i < newTotSize; i++) {        //count i starting at the size of this tracks = the place after the last track in 'this' and move forward
                    this.add (i, other.getTrack(j));                  //now add the new tracks from other in the first place when 'this' tracks ends and move forward adding all 'that' tacks
                    j++;
                }
        }
    }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        //// replace the following statement with your code
        if (start < 0 || start > this.size) {                 //if the index given to us to start from is negative or larger than size return -1
            return -1;
        }
        int minIndex = start;                                        //making the index given to us be the one we start checking from
        int durationMinTrack = this.tracks[start].getDuration();       //saves the duration of the minimal track
        for (int i = start +1; i < this.size; i++) {                   //going over the list from the index we got as start
            if (this.tracks[i].getDuration() <= durationMinTrack){       //if the track in this index is shorter than the previous minimal duration saved
                minIndex = i;                                       //save it as the new index in which the track is minimal duration
                durationMinTrack = this.tracks[i].getDuration();       //and save its duration to furthur check for a smaller duration track
            }
        }
        return minIndex;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
        for (int i = 0; i < this.size; i++) {             //go over the tracks list
        int minDurIndx = minIndex(i);                     //save the index of the track with the minimal duration
        Track temp = this.tracks[i];                        //save the index of the track we're checking
        this.tracks[i] = this.tracks[minDurIndx];          //if the track we just checked equals the minIndex we found
        this.tracks[minDurIndx] = temp;                     //calling the minIndex method \
        }
    }
}
