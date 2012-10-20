/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class ProcessingGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-processing-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = "Render 2D/3D content with Processing"
    String description = '''
[Processing][1] is an open source programming language and environment for people who want to program images, animation,
and interactions. This plugin lets you embed a Processing view into a Griffon application.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*     | *Type*                    |
| ---------- | ------------------------- |
| processing | `processing.core.PApplet` |

Configuration
-------------

You must install the [jogl-compat][2] plugin if you intend to draw 3D scenes. The [jogl][3] plugin will not work as it provides a
more recent version of JOGL that is incompatible with Processing's requirements.

Scripts
-------

 * **create-processing-view** - creates a new PApplet class at `$basedir/griffon-app/processing`. You can embed that class
 into a View script using the `processing` node.

## Example

Embedding a _Processing_ View in an MVC group is simple. Just follow these steps

1. Create an application named `sample`

        $ griffon create-app sample

2. Insatll the processing plugin

        $ cd sample
        $ griffon install-plugin processing

3. Create a brand new Processing view

        $ griffon create-processing-view sample

4. Open up `griffon-app/processing/sample/SampleProcessingView.java` and edit the file according to your liking.

5. Configure the processing View to be used with the default MVC group. In `Application.groovy`:

        mvcGroups {
            // MVC Group for "sample"
            'sample' {
                model      = 'sample.SampleModel'
                papplet    = 'sample.FirstProcessingView'
                view       = 'sample.SampleView'
                controller = 'sample.SampleController'
            }
        }

6. Use the `papplet` MVC member in a View

        package sample
        application(title: 'sample',
          preferredSize: [320, 240],
          pack: true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            processing(papplet)
        }


[1]: http://processing.org/
[2]: /plugin/jogl-compat
[3]: /plugin/jogl
'''
}