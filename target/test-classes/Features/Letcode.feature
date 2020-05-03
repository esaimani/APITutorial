Feature: Test the Letcode Site Functionality
@Letcode
Scenario Outline: Validate Input Workspace
Given Launch the "<url>" Letcode website  
And Navigate to workspace
And Navigate to Input Blog
When Enter the Firstname "<firstname>"
And Append a exisiting text "<newtext>"
And Get the textbox value
And Clear the text
And Verify the Invitable textbox is disabled
Examples:
| url| firstname | newtext |
| https://letcode.in/ | Esaimani  | person  | 

@Frame
Scenario: Validate Frames Concept
Given Launch the "<url>" Letcode website  
And Navigate to workspace
And Navigate to Frame Blog
