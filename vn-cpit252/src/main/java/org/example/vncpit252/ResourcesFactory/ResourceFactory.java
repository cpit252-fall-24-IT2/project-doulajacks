package org.example.vncpit252.ResourcesFactory;

public class ResourceFactory {

    public ResourceType createResource(String resource, ResourceDesignPattern designPattern) {
        if (resource.equals("Reading")) {
            return new Reading(designPattern.toString());
        }
        else if (resource.equals("Code")) {
            return new Code(designPattern.toString());
        }
        else if (resource.equals("Video")) {
            return new Video(designPattern.toString());
        }
        else {
            System.out.println("Please enter correct resource type");
        }
        return null;
    }

}
