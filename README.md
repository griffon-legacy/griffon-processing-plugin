
Render 2D/3D content with Processing
------------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/processing](http://artifacts.griffon-framework.org/plugin/processing)


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

