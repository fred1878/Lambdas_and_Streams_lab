package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Extension {
    /*
        Given two int numbers a and b, return int [] with values that are in the range between smaller and bigger arg:
        - use IntStream.range
        - swap the argument's values without introducing a new, local variable.
    */
    public int [] streamNumbers(int a, int b) {
        if(b<a){
            a = a+b;
            b = a-b;
            a = a-b;
        }
        IntStream stream = IntStream.range(a,b);
        int[] array = stream.toArray();
        return array;
    }

    /*
        Given a list of users, return a User with the given user id. If there is no user with this id,
        return new user with the name "New user", given id, gender "unknown".

        (use Optional API)
    */
    public User getUserByIdOrCreateNew(List<User> users, long userId) {
        Stream<User> stream = users.stream();
        User user = stream.filter(u -> u.getId()==userId).findAny().orElse(new User(123456,"New user", User.GENDER.UNKNOWN));
        return user;
    }

    /*
        Given List<Friend>, filter the ones who are available on Saturday and want to party:
        - getAvailableDay returns "Saturday" and
        - getActivity returns "Party"
        - define predicates and use '.and' method.
    */

    public List<String> partyWithFriends(List<Friend> friends) {
        Predicate<Friend> saturday = friends.
        Predicate<Friend> party = Predicate.isEqual("Party");
        List<String> canParty = friends.stream().filter(f -> f.getAvailableDay(saturday).and(f.getActivity(party))).collect(Collectors.toList());
        return canParty;
    }

    /*
        Return names of sorted bodybuilders.

        Sort List<Bodybuilder> using your custom comparator.

        Write a comparator for type BodyBuilder that will sort bodybuilders by:
        - who can lift more,
        - then who is younger,
        - then name alphabetically.
     */
    public List<String> sortBodybuilders(List<Bodybuilder> bodybuilders) {
        // Implement me :)
        return null;
    }

}
