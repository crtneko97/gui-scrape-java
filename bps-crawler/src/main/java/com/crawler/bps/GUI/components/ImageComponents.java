package com.crawler.bps.GUI.components;

import javax.swing.*;
import java.awt.*;

public class ImageComponents {

    /**
     * Creates a JLabel containing an image.
     *
     * @param imagePath The path to the image file.
     * @param width Desired width of the image.
     * @param height Desired height of the image.
     * @return A JLabel with the scaled image.
     */
    public static JLabel createImageLabel(String imagePath, int width, int height) {
        try {
            // Load the image
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Scale the image to the desired size
            Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Create and return a JLabel with the scaled image
            return new JLabel(scaledIcon);

        } catch (Exception e) {
            // Log error and return an empty JLabel if the image can't be loaded
            System.err.println("Error loading image: " + imagePath);
            e.printStackTrace();
            return new JLabel("Image not found");
        }
    }
}
