package org.svelto.plugin

import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext
import org.eclipse.core.runtime.Status

class SveltoPlugin extends AbstractUIPlugin {

  override def start(context: BundleContext) {
    super.start(context)
    SveltoPlugin.plugin = this
  }

  override def stop(context: BundleContext) {
    SveltoPlugin.stopped = true
  }
}

object SveltoPlugin {
  @volatile
  private var plugin: SveltoPlugin = null

  @volatile
  var stopped = false

  def apply(): SveltoPlugin = plugin

  def log(status: Int, msg: String, ex: Throwable = null) {
    println(msg)
    plugin.getLog.log(new Status(status, plugin.getBundle().getSymbolicName(), msg, ex))
  }
}