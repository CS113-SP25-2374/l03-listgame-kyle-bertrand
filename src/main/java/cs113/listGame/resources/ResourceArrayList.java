package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.ArrayList;

public class ResourceArrayList implements ResourceList {
    private ArrayList<ResourceObject> resources = new ArrayList<>();
    public ResourceArrayList() {};

    @Override
    public void add(ResourceObject resource) {
        if(!resources.contains(resource)) {
            resources.add(resource);
        }
    }

    @Override
    public void remove(ResourceObject resource) {
        resources.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        int index = resources.indexOf(resource);
        if(index != -1){
            resources.subList(index, resources.size()).clear();
        }
    }

    @Override
    public void follow(GameObject leader) {
        for ( ResourceObject resource : resources) {
            if(resource != null){
                resource.moveTowards((leader.getEchoCenter()));
                leader = resource;
            }
        }
    }
}
