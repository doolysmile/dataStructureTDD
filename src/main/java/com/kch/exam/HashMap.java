package com.kch.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HashMap<K,V>{
    Object[] keys;
    Object[] values;

    int index;
    HashMap(){
        keys = new Object[2];
        values = new Object[2];
        index = -1;
    }

    public void put(K key, V value){
        extendHashMap();
        for(int i = 0; i <= index; i++){
            if(keys[i] == key){
                values[i] = value;
                return;
            }
        }
        index++;
        keys[index] = key;
        values[index] = value;
    }

    public V get(K key){
        for(int i = 0; i <= index; i++){
            if(keys[i].equals(key)){
                return (V)values[i];
            }
        }
        return null;
    }

    public void remove(K key){
        for(int i = 0; i <= index; i++){
            if(keys[i].equals(key)){
                remove(i);
            }
        }
    }
    public void remove(int i){
        for(int j = i; j < i; j++){
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        index--;
    }

    public int size(){
        return index + 1;
    }

    //    public K[] keySet(){
//        Object[] tmp = new Object[index + 1];
//        for(int i = 0; i <= index; i++){
//            tmp[i] = keys[i];
//        }
//        return (K[]) tmp;
//    }
//    Set<K> keySet() {
//        Set<K> keySet = new HashSet<>();
//
//        for ( int i = 0; i <= index; i++ ) {
//            keySet.add((K)keys[i]);
//        }
//        return keySet;
//    }
    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();

        for ( int i = 0; i <= index; i++ ) {
            keySet.add((K)keys[i]);
        }

        return keySet;
    }
    public void extendHashMap(){
        int len = keys.length;
        if(index + 1 >= len){
            Object[] newKeys = new Object[len*2];
            Object[] newValues = new Object[len*2];
            for(int i = 0; i < len; i++){
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }
            keys = newKeys;
            values = newValues;
        }
    }

}